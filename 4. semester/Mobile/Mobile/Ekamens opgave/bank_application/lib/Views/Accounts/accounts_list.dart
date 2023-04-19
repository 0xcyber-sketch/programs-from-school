import 'package:bank_application/Controller/state_controller.dart';
import 'package:bank_application/Model/account.dart';
import 'package:bank_application/Views/Accounts/accounts_list_row.dart';
import 'package:bank_application/Views/Forms/create_account_form.dart';

import 'package:flutter/material.dart';

import 'package:provider/provider.dart';

class AccountsList extends StatelessWidget {
  const AccountsList({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.brown[50],
        body: Container(
            child: Column(children: [
          const SizedBox(height: 55),
          const Center(
              child: Text(
            "Account overview",
            textDirection: TextDirection.ltr,
            style: TextStyle(
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
              child: Consumer<StateController>(
                  builder: (context, _stateController, widget) {
                return MediaQuery.removePadding(
                    removeTop: true,
                    context: context,
                    child: ListView.separated(
                        scrollDirection: Axis.vertical,
                        shrinkWrap: true,
                        separatorBuilder: (context, index) => Divider(
                              color: Colors.brown[50],
                            ),
                        itemCount: _stateController.amountOfAccounts,
                        itemBuilder: (context, index) {
                          final Account account =
                              _stateController.accounts[index];
                          return AccountListRow(account: account);
                        }));
              }))
        ])),
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
                          builder: (context) => CreateAccountForm()));
                },
                child: Row(mainAxisAlignment: MainAxisAlignment.end, children: [
                  Icon(Icons.add_circle_outlined,
                      color: Colors.brown[50], size: 17),
                  const SizedBox(width: 4),
                  Text(
                    "Create Account",
                    style: TextStyle(color: Colors.brown[50]),
                  ),
                  const SizedBox(width: 20)
                ]))));
  }
}
