import 'package:angular/angular.dart';
import 'package:pokemon_app/src/pokemon.dart';
import 'package:angular_forms/angular_forms.dart';

@Component(
  selector: 'app-component',
/*   template: '''
    <h1>{{i_came_from}}</h1>
    <h2>Hello {{name}}</h2>
  ''', */
  templateUrl: 'app_component.html',
  styleUrls: ['app_component.css'],
  directives: [formDirectives],
)
class AppComponent {
  var name = 'Angular';
  final i_came_from = 'I came from Flutter';
  Pokemon pokemon = Pokemon(id: 1, name: 'Pikachu');
}
