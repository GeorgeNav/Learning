import 'package:firebase/firebase.dart';
import 'package:firebase/firestore.dart' as fs;

void main() {
  initializeApp(
    apiKey: "AIzaSyCuirHXp2UuvekDCNPrt0IXUXUDBAT5Xz0",
    authDomain: "fireship-8ce36.firebaseapp.com",
    databaseURL: "https://fireship-8ce36.firebaseio.com",
    projectId: "fireship-8ce36",
    storageBucket: "fireship-8ce36.appspot.com",
    messagingSenderId: "893653071775",
  );

  Database db = database();
  DatabaseReference ref = db.ref("messages");

  ref.onValue.listen((e) {
    DataSnapshot datasnapshot = e.snapshot;
    // Do something with datasnapshot
    print(datasnapshot.exists());
  });
}

/*
<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/6.0.2/firebase-app.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#config-web-app -->

<script>
  // Your web app's Firebase configuration
  var firebaseConfig = {
    apiKey: "AIzaSyCuirHXp2UuvekDCNPrt0IXUXUDBAT5Xz0",
    authDomain: "fireship-8ce36.firebaseapp.com",
    databaseURL: "https://fireship-8ce36.firebaseio.com",
    projectId: "fireship-8ce36",
    storageBucket: "fireship-8ce36.appspot.com",
    messagingSenderId: "893653071775",
    appId: "1:893653071775:web:5073e67faeb23571"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
</script>
*/