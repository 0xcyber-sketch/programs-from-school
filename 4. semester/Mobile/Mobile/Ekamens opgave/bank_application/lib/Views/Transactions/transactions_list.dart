import 'package:bank_application/Model/account.dart';
import 'package:bank_application/Model/transactions.dart';
import 'package:bank_application/Views/Forms/create_transaction_form.dart';
import 'package:bank_application/Views/Transactions/transactions_list_row.dart';

import 'package:flutter/material.dart';

class TransactionsList extends StatelessWidget {
  final Account account;
  const TransactionsList({Key? key, required this.account}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.brown[50],
        body: Column(children: [
          const SizedBox(height: 55),
          Align(
              alignment: Alignment.centerLeft,
              child: TextButton(
                  onPressed: () {
                    Navigator.pop(context);
                  },
                  child: Row(
                    children: const [
                      SizedBox(width: 12),
                      Icon(Icons.arrow_back_ios, size: 17),
                      Text("Accounts"),
                    ],
                  ))),
          const SizedBox(height: 10),
          Center(
              child: Text(
            account.name,
            textDirection: TextDirection.ltr,
            style: const TextStyle(
                fontSize: 30,
                fontWeight: FontWeight.bold,
                color: Color.fromARGB(255, 74, 74, 74)),
          )),
          const SizedBox(height: 20),
          Container(
              height: 500,
              decoration: const BoxDecoration(
                borderRadius: BorderRadius.all(Radius.circular(10)),
                color: Color.fromARGB(255, 50, 50, 50),
              ),
              margin: const EdgeInsets.fromLTRB(12, 0, 12, 0),
              child: MediaQuery.removePadding(
                  context: context,
                  removeTop: true,
                  child: ListView.separated(
                      scrollDirection: Axis.vertical,
                      shrinkWrap: true,
                      separatorBuilder: (context, index) => Divider(
                            color: Colors.brown[50],
                          ),
                      itemCount: account.transactions.length,
                      itemBuilder: (context, index) {
                        final Transactions transaction =
                            account.transactions.reversed.toList()[index];
                        return TransactionListRow(transaction: transaction);
                      })))
        ]),
        bottomNavigationBar: Container(
            height: 30,
            margin: const EdgeInsets.fromLTRB(12, 0, 12, 0),
            decoration: const BoxDecoration(
              color: Color.fromARGB(255, 50, 50, 50),
              borderRadius: BorderRadius.only(
                topLeft: Radius.circular(10),
                topRight: Radius.circular(10),
              ),
            ),
            child: TextButton(
                onPressed: () {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) =>
                              CreateTransactionForm(account: account)));
                },
                child: Row(mainAxisAlignment: MainAxisAlignment.end, children: [
                  Icon(Icons.add_circle_outlined,
                      color: Colors.brown[50], size: 17),
                  const SizedBox(width: 4),
                  Text(
                    "Create Transaction",
                    style: TextStyle(color: Colors.brown[50]),
                  ),
                  const SizedBox(width: 20)
                ]))));
  }
}
