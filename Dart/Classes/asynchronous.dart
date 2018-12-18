// https://www.dartlang.org/tutorials/language/futures
import 'dart:html';
import 'dart:async';

void handleSuccess(String response) => print('Request was successful: ' + response);
void handleError(String error) => print('The request was not successful' + error);

main() { // Works in DartPad (browser)
  mainNormal();
  mainUsingAsync();
}

mainNormal() {
  var result = HttpRequest.getString('https://rebounce.online/api/time');
  result.then(handleSuccess);
  result.catchError(handleError);
  print('mainNormal has ended');
}

Future<void> mainUsingAsync() async {
  try {
    final response = await HttpRequest.getString('https://rebounce.online/api/time');
    print('Request was successful: ');
    print(response);
  } catch(error) {
    print('Request was not successful: ');
    print(error);
  }
  print('mainUsingAsync has ended');
}