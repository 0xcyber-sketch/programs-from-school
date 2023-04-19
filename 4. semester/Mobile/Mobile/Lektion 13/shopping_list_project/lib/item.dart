import 'dart:convert';

class Item {
  late String name;
  late int amount;
  String id;
  late String department;

  Item({
    this.name = "",
    this.amount = 0,
    this.department = "",
    this.id = "",
  });

  Map<String, dynamic> toMap() {
    return {
      'name': name,
      'amount': amount,
      'department': department,
    };
  }

  factory Item.fromMap(Map<String, dynamic> map, String id) {
    return Item(
      name: map['name'],
      amount: map['amount'],
      id: id,
      department: map['department'],
    );
  }

  String toJson() => json.encode(toMap());

  factory Item.fromJson(String source, String id) =>
      Item.fromMap(json.decode(source), id);
}
