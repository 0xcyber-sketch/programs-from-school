import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:shopping_list_project/controller.dart';
import 'package:shopping_list_project/item.dart';

import 'department_enum.dart';

class AddItemFormRoute extends StatefulWidget {
  const AddItemFormRoute({Key? key}) : super(key: key);

  @override
  State<AddItemFormRoute> createState() => _AddItemFormRouteState();
}

class _AddItemFormRouteState extends State<AddItemFormRoute> {
  final _formKey = GlobalKey<FormState>();
  final Item _item =
      Item(name: "", amount: 0, department: DepartmentEnum.Vegetables);
  String _currentSelectedValue = DepartmentEnum.Vegetables;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Add Shopping Item"),
          centerTitle: true,
        ),
        body: Form(
          key: _formKey,
          child: Column(children: [
            TextFormField(
                decoration: const InputDecoration(labelText: "Title"),
                onSaved: (value) => setState(() => _item.name = value!),
                validator: (value) {
                  validateEmpty(value, "Title");
                }),
            const SizedBox(height: 15),
            TextFormField(
                keyboardType: TextInputType.number,
                decoration: const InputDecoration(labelText: "Amount"),
                onSaved: (value) => setState(() {
                      if (value != null) {
                        _item.amount = int.parse(value);
                      }
                    }),
                validator: (value) {
                  validateEmpty(value, "Amount");
                }),
            const SizedBox(height: 15),
            FormField<String>(
              builder: (FormFieldState<String> state) {
                return InputDecorator(
                  decoration: const InputDecoration(
                    errorStyle:
                        TextStyle(color: Colors.redAccent, fontSize: 16.0),
                    hintText: 'Please select department',
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
                            _item.department = newValue;
                          }
                        });
                      },
                      items: departmentsList().map((String value) {
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
            const SizedBox(height: 15),
            ElevatedButton(
                onPressed: () {
                  final form = _formKey.currentState;
                  if (form!.validate()) {
                    form.save();
                    Provider.of<Controller>(context, listen: false)
                        .addItem(_item);
                    Navigator.pop(context);
                  }
                },
                child: const Text("Submit"))
          ]),
        ));
  }
}

validateEmpty(dynamic value, String textFieldName) {
  if (value.isEmpty) {
    return 'Enter text in ' + textFieldName;
  }
  return null;
}

List<String> departmentsList() {
  List<String> list = [];
  list.add(DepartmentEnum.Vegetables);
  list.add(DepartmentEnum.Frozon);
  list.add(DepartmentEnum.Dairy);
  list.add(DepartmentEnum.Dry);
  list.add(DepartmentEnum.BeerWater);
  list.add(DepartmentEnum.NoneFood);
  return list;
}
