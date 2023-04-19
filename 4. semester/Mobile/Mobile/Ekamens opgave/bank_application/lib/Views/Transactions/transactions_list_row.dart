import 'package:bank_application/Controller/state_controller.dart';
import 'package:bank_application/Model/transactions.dart';
import 'package:flutter/material.dart';

class TransactionListRow extends StatelessWidget {
  final Transactions transaction;
  const TransactionListRow({Key? key, required this.transaction})
      : super(key: key);
  @override
  Widget build(BuildContext context) {
    return ListTile(
        title: Text(
          transaction.reciever,
          style: TextStyle(
              color: Colors.brown[50],
              fontWeight: FontWeight.w400,
              fontSize: 15),
        ),
        subtitle: Text(
          StateController.formatDateforTransaction(transaction),
          style: const TextStyle(
            fontSize: 12,
            color: Color.fromARGB(255, 201, 196, 194),
          ),
        ),
        trailing: Text(
          "DKK " + transaction.amount.toString(),
          style: TextStyle(
              color: Colors.brown[50],
              fontWeight: FontWeight.w400,
              fontSize: 15),
        ));
  }
}
