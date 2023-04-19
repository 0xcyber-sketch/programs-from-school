import 'package:bank_application/Controller/state_controller.dart';
import 'package:bank_application/Model/account.dart';
import 'package:bank_application/Model/transactions.dart';

import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:uuid/uuid.dart';

class CreateAccountForm extends StatefulWidget {
  const CreateAccountForm({Key? key}) : super(key: key);

  @override
  State<CreateAccountForm> createState() => _CreateAccountFormState();
}

class _CreateAccountFormState extends State<CreateAccountForm> {
  final _formKey = GlobalKey<FormState>();
  final Account _account = Account(
      name: "", iban: generateIBAN(), type: "Checking", transactions: []);
  String _currentSelectedValue = "Checking";

  void validateAndSave() {
    final form = _formKey.currentState;
    if (form!.validate()) {
      form.save();
      Provider.of<StateController>(context, listen: false).addAccount(_account);
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
          const SizedBox(height: 50),
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
                  child: Text("New Account",
                      style: TextStyle(
                          color: Color.fromARGB(255, 50, 50, 50),
                          fontSize: 40,
                          fontWeight: FontWeight.bold)))),
          const SizedBox(height: 10),
          Container(
            margin: const EdgeInsets.fromLTRB(12, 0, 12, 0),
            child: TextFormField(
                decoration: const InputDecoration(
                  labelText: "Account Name",
                  border: OutlineInputBorder(),
                  contentPadding: EdgeInsets.all(8),
                ),
                onSaved: ((value) => setState(() {
                      if (value != null) {
                        _account.name = value;
                      }
                    })),
                validator: (value) {
                  return validateEmpty(value, "Account name");
                }),
          ),
          const SizedBox(height: 15),
          Container(
            margin: const EdgeInsets.fromLTRB(12, 0, 12, 0),
            child: FormField<String>(
              builder: (FormFieldState<String> state) {
                return InputDecorator(
                  decoration: const InputDecoration(
                    errorStyle:
                        TextStyle(color: Colors.redAccent, fontSize: 16.0),
                    hintText: 'Please select department',
                    border: OutlineInputBorder(),
                    labelText: 'Account Type',
                    contentPadding: EdgeInsets.all(8), // Added this
                  ),
                  isEmpty: _currentSelectedValue == '',
                  child: DropdownButtonHideUnderline(
                    child: DropdownButton<String>(
                      value: _currentSelectedValue,
                      isDense: true,
                      onChanged: (newValue) {
                        setState(() {
                          if (newValue != null) {
                            _currentSelectedValue = newValue;
                            state.didChange(newValue);
                            _account.type = newValue;
                          }
                        });
                      },
                      items: ["Checking", "Savings", "Investment"]
                          .map((String value) {
                        return DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        );
                      }).toList(),
                    ),
                  ),
                );
              },
            ),
          ),
        ]),
      ),
    ));
  }
}

validateEmpty(dynamic value, String textFieldName) {
  if (value.isEmpty) {
    return 'Enter text in ' + textFieldName;
  }
  return null;
}

String generateIBAN() {
  var uuid = Uuid();

  String iban = uuid.v1().toString().substring(0, 15);
  return iban;
}
