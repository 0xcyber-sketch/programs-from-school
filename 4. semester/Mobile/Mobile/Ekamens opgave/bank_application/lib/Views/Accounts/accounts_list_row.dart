import 'package:bank_application/Controller/state_controller.dart';
import 'package:bank_application/Model/account.dart';
import 'package:bank_application/Views/Transactions/transactions_list.dart';
import 'package:flutter/material.dart';

class AccountListRow extends StatelessWidget {
  final Account account;
  const AccountListRow({Key? key, required this.account}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return ListTile(
        onTap: () {
          Navigator.push(
              context,
              MaterialPageRoute(
                  builder: (context) => TransactionsList(account: account)));
        },
        title: Text(account.name,
            style: TextStyle(
                color: Colors.brown[50],
                fontWeight: FontWeight.w400,
                fontSize: 20)),
        subtitle: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(account.iban,
                style: const TextStyle(
                  color: Color.fromARGB(255, 201, 196, 194),
                )),
            const SizedBox(
              width: 5,
            ),
            Text(account.type,
                style:
                    const TextStyle(color: Color.fromARGB(255, 201, 196, 194))),
          ],
        ),
        trailing: Text(
          "DKK " + StateController.generateBalanceForAccount(account),
          style: TextStyle(
              color: Colors.brown[50],
              fontWeight: FontWeight.w400,
              fontSize: 20),
        ));
  }
}
