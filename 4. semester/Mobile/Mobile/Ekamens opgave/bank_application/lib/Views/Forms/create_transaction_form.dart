import 'dart:ffi';

import 'package:bank_application/Controller/state_controller.dart';
import 'package:bank_application/Model/account.dart';
import 'package:bank_application/Model/transactions.dart';

import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:uuid/uuid.dart';

class CreateTransactionForm extends StatefulWidget {
  final Account account;
  const CreateTransactionForm({Key? key, required this.account})
      : super(key: key);

  @override
  State<CreateTransactionForm> createState() => _CreateTransactionFormState();
}

class _CreateTransactionFormState extends State<CreateTransactionForm> {
  final _formKey = GlobalKey<FormState>();
  final Transactions _transaction =
      Transactions(creationDate: DateTime.now(), amount: 0, reciever: "");

  void validateAndSave() {
    final form = _formKey.currentState;
    if (form!.validate()) {
      form.save();
      widget.account.transactions.add(_transaction);
      Provider.of<StateController>(context, listen: false)
          .addAccountWithID(widget.account);
      Navigator.pop(context);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Form(
      key: _formKey,
      child: Container(
        margin: const EdgeInsets.fromLTRB(16, 0, 16, 0),
        child: Column(children: [
          const SizedBox(height: 55),
          Row(
            children: [
              Align(
                  alignment: Alignment.centerLeft,
                  child: TextButton(
                      onPressed: () {
                        Navigator.pop(context);
                      },
                      child: const Text("Cancel"))),
              const SizedBox(width: 230),
              TextButton(
                  onPressed: () {
                    validateAndSave();
                  },
                  child: const Text("Create")),
            ],
          ),
          const SizedBox(height: 20),
          Container(
              margin: const EdgeInsets.fromLTRB(12, 0, 12, 0),
              child: const Align(
                  alignment: Alignment.centerLeft,
                  child: Text("New Transaction",
                      style: TextStyle(
                          color: Color.fromARGB(255, 50, 50, 50),
                          fontSize: 40,
                          fontWeight: FontWeight.bold)))),
          const SizedBox(height: 10),
          Container(
            margin: const EdgeInsets.fromLTRB(12, 0, 12, 0),
            child: TextFormField(
                keyboardType: TextInputType.number,
                decoration: const InputDecoration(
                    labelText: "Amount",
                    border: OutlineInputBorder(),
                    contentPadding: EdgeInsets.all(8)),
                onSaved: (value) => setState(() {
                      if (value != null && value.isNotEmpty) {
                        _transaction.amount = double.parse(value);
                      }
                    }),
                validator: (value) {
                  return validaters(value, "Amount");
                }),
          ),
          const SizedBox(height: 15),
          Container(
            margin: const EdgeInsets.fromLTRB(12, 0, 12, 0),
            child: TextFormField(
                onSaved: (value) =>
                    setState(() => _transaction.reciever = value!),
                decoration: const InputDecoration(
                  labelText: "Reciver",
                  border: OutlineInputBorder(),
                  contentPadding: EdgeInsets.all(8),
                ),
                validator: (value) {
                  return validaters(value, "Reciver");
                }),
          ),
          const SizedBox(height: 15),
        ]),
      ),
    ));
  }

  validaters(dynamic value, String textFieldName) {
    if (validateEmpty(value, textFieldName) != null) {
      return validateEmpty(value, textFieldName);
    }
    if (textFieldName == "Amount") {
      if (validateAmountCharacters(value, textFieldName) != null) {
        return validateAmountCharacters(value, textFieldName);
      }

      if (validateBalanceNotEqualZero(value, textFieldName) != null) {
        return validateBalanceNotEqualZero(value, textFieldName);
      }
    }
    return null;
  }

  validateEmpty(dynamic value, String textFieldName) {
    if (value.isEmpty) {
      return 'Enter text in ' + textFieldName;
    }
    return null;
  }

  validateAmountCharacters(dynamic value, String textFieldName) {
    final legalChars = [
      '0',
      '1',
      '2',
      '3',
      '4',
      '5',
      '6',
      '7',
      '8',
      '9',
      ',',
      '.',
      '-'
    ];

    for (String element in value.toString().characters) {
      if (!legalChars.contains(element)) {
        return textFieldName + "  has an Illegal character (White space)";
      }
    }
    return null;
  }

  validateBalanceNotEqualZero(dynamic value, String textFieldName) {
    if (value.toString().isNotEmpty) {
      if (widget.account.withdraw(double.parse(value))) {
        return null;
      } else {
        return textFieldName + " - balance can't be less than 0";
      }
    }
  }
}
