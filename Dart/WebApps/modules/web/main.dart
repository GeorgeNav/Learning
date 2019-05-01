/// MVC (module-veiw-controller)
/// Model: what to do with data given by controller
/// View: what the user sees (html/DOM)
/// Controller: where interactions go (routes)

import 'package:angular/angular.dart';
import 'package:modules/app_component.template.dart' as ng;

void main() {
  runApp(ng.AppComponentNgFactory);
}
