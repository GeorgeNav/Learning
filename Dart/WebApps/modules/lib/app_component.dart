import 'package:angular/angular.dart';
import 'package:angular_forms/angular_forms.dart';
/* import 'package:modules/todo_list/todo_list.dart'; */

@Component(
  selector: 'app-component',
  styleUrls: ['app_component.css'],
  templateUrl: 'app_component.html',
  directives: const [
    coreDirectives,
    formDirectives,
  ],
)
class AppComponent {
  Map whichClasses = {
    "first": false,
    "aClass1": true,
    "aClass2": true,
  };
  var name = 'Angular';
  var inputType = 'text';
  var something = 'hehe';
  var cssProp = false;
  var exist = true;
  var car = "toyota";
  var cars = ["toyota","buick", "yaris"];
  goodJob() => name = 'Good Job!';
  changeClass() => cssProp = !cssProp;
  clear() => car = "";

}
