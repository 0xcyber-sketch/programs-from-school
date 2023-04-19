import 'package:bank_application/Model/account.dart';
import 'package:bank_application/Model/transactions.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import '../Services/firebase_service.dart';

class StateController extends ChangeNotifier {
  final List<Account> accounts = [];
  // var firebaseServiceAccount = db_firebase_storage().accountRef;
  var firebaseService = db_firebase_storage();
  //

  StateController() {
    // listener
    firebaseService.accountRef.snapshots().listen((documents) {
      accounts.clear();
      for (var d in documents.docs) {
        accounts.add(d.data());
      }
      notifyListeners();
    });
  }

  void addAccount(Account a) async {
    await firebaseService.addAccount(a);
    notifyListeners();
  }

  void addAccountWithID(Account a) async {
    try {
      await firebaseService.deleteAccount(a.id);
      await firebaseService.addAccountWithID(a);
    } catch (execption) {
      await firebaseService.addAccountWithID(a);
    }
    notifyListeners();
  }

  int get amountOfAccounts {
    return accounts.length;
  }

  static String generateBalanceForAccount(Account account) {
    double balance = 0;
    for (var element in account.transactions) {
      balance += element.amount;
    }

    return balance.toString();
  }

  static String formatDateforTransaction(Transactions transaction) {
    String dateString =
        DateFormat("MMM dd, yyyy").format(transaction.creationDate).toString();

    return _formatFirstChar(dateString);
  }

  static String _formatFirstChar(String s) {
    String firstChar = s.substring(0, 1);
    String newString = firstChar.toUpperCase() + s.substring(1);

    return newString;
  }
}
