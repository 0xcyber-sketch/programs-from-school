import 'dart:convert';

class Transactions {
  double amount;
  DateTime creationDate;
  String reciever;

  Transactions({
    this.amount = 0.0,
    required this.creationDate,
    this.reciever = "",
  });

  Map<String, dynamic> toJSON() {
    return {
      'amount': amount,
      'creationDate': creationDate.toIso8601String(),
      'reciever': reciever,
    };
  }

  Transactions.fromJSON(Map<String, dynamic> json)
      : amount = json['amount'],
        creationDate = DateTime.parse(json['creationDate']),
        reciever = json['reciever'];
}
