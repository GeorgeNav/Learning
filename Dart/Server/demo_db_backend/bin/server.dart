import 'dart:io' as io;

import 'package:postgres/postgres.dart' as pg;
import 'package:args/args.dart';
import 'package:shelf/shelf.dart' as shelf;
import 'package:shelf/shelf_io.dart' as shelf_io;

// For Google Cloud Run, set _hostname to '0.0.0.0'.
const _hostname = 'localhost';

main(List<String> args) async {
  print(args);
  var parser = ArgParser()..addOption('port', abbr: 'p');
  var result = parser.parse(args);

  // For Google Cloud Run, we respect the PORT environment variable
  var portStr = result['port'] ?? io.Platform.environment['PORT'] ?? '8080';
  var port = int.tryParse(portStr);

  if (port == null) {
    io.stdout.writeln('Could not parse port value "$portStr" into a number.');
    // 64: command line usage error
    io.exitCode = 64;
    return;
  }

  var handler = const shelf.Pipeline()
      .addMiddleware(shelf.logRequests())
      .addHandler(_echoRequest);

  var server = await shelf_io.serve(handler, _hostname, port);
  print('Serving at http://${server.address.host}:${server.port}');

  //var val = mssql.SqlConnection(db: "demo_db", host: "gn-demo-server.database.windows.net", password: "Dangaronihehe123!", user: "georgenav");
  pg.PostgreSQLConnection("demo-pdb.postgres.database.azure.com", 8080, "demp-pdb", username: "georgenav", password: "Dangaronihehe123!");
}

shelf.Response _echoRequest(shelf.Request request) =>
    shelf.Response.ok('Request for "${request.url}"');
