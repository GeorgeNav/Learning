# How to create an project the right way
flutter create --org com.yourdomain appname

# Accept licenses for android tool chain? 
flutter doctor --android-licenses

# Open ios (current folder) directory in xcode
xed ./

# get SHA1
keytool -list -v \
-alias androiddebugkey -keystore ~/.android/debug.keystore

# Flutter web
flutter channel master
flutter upgrade
flutter packages pub run build_runner build
pub get
webdev serve -r