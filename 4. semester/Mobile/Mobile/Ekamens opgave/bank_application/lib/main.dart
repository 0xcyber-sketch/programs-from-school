import 'package:bank_application/Views/Accounts/accounts_list.dart';
import 'package:bank_application/Controller/state_controller.dart';
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';
import 'package:intl/date_symbol_data_local.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();

  await initializeDateFormatting();
  Intl.defaultLocale = 'da';

  runApp(ChangeNotifierProvider(
    create: (context) => StateController(),
    child: const MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(title: 'Bank Account', home: AccountsList());
  }
}
