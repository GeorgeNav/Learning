class Performer {
  static var mood = 'Having a good time'; // Static value's class doesn't need to be instanced to be used (lowerCamelCase)
  static int getFear() => 0;
}

class Musican extends Performer with Musical { // Performer is the parent and uses code in Musical

}

mixin Musical { // this code can be used from class without having to be a parent
  bool canPlayPiano = false;
  bool canCompose = false;
  bool canConduct = false;
  void entertainMe() {
    if(canPlayPiano) print('Playing piano');
    else if(canConduct) print('Waving hands');
    else print('Humming to self');
  }
}

mixin MusicalPerformer on Musican { // allows Musican to use it's code

}

main() {
  print('\t Mood: ${Performer.mood} \n\t Fear: ${Performer.getFear()}');
  Performer.mood = 'Not having a good time'; // can change a class's static value
  print('\t Mood: ${Performer.mood} \n\t Fear: ${Performer.getFear()}');
}