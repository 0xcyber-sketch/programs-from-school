import 'package:bank_application/Model/account.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:bank_application/Model/transactions.dart';

class db_firebase_storage {
  final FirebaseFirestore firestore = FirebaseFirestore.instance;

  final accountRef =
      FirebaseFirestore.instance.collection("Accounts").withConverter<Account>(
            fromFirestore: (snapshot, _) =>
                Account.fromJSON(snapshot.data()!, snapshot.id),
            toFirestore: (account, _) => account.toJSON(),
          );

  addAccount(Account account) async {
    await accountRef.add(account);
  }

  addAccountWithID(Account account) async {
    await accountRef.doc(account.id).set(account);
  }

  deleteAccount(String accountID) async {
    await accountRef.doc(accountID).delete();
  }

  /*addTransactionToAccount(String accountID) async {
    await accountRef.doc(accountID).update()
  }*/
}
