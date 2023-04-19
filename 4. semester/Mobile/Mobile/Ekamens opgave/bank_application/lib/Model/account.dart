import 'package:bank_application/Model/transactions.dart';

class Account {
  String name;
  String iban;
  String type;
  String id;

  List<Transactions> transactions;

  Account(
      {this.name = "",
      this.iban = "",
      this.id = "",
      required this.type,
      required this.transactions});

  Map<String, dynamic> toJSON() {
    return {
      'name': name,
      'iban': iban,
      'type': type,
      'transactions':
          transactions.map((transaction) => transaction.toJSON()).toList()
    };
  }

  Account.fromJSON(Map<String, dynamic> json, String documentID)
      : name = json['name'],
        iban = json['iban'],
        id = documentID,
        type = json['type'],
        transactions = List<dynamic>.from(json["transactions"])
            .map((transaction) => Transactions.fromJSON(transaction))
            .toList();

  double getAccountBalance() {
    double balance = 0.0;
    if (transactions.isNotEmpty) {
      for (var element in transactions) {
        balance += element.amount;
      }
    }
    return balance;
  }

  bool withdraw(double amount) {
    double balance = getAccountBalance();
    if (amount + balance < 0) return false;

    return true;
  }
}
