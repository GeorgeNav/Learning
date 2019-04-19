import 'package:angular/angular.dart';

@Component (
  selector: 'my-app', // display in <my-app> tag
  template: '<h1>Hello {{name}}</h1>', // what to display
)

class AppComponent {
  var name = 'Angular';
}