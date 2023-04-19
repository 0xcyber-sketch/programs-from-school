import 'package:flutter/material.dart';
import 'package:shopping_list_project/item.dart';

import 'firebase_service.dart';

//app state
class Controller extends ChangeNotifier {
  final List<Item> _shopping_items = [];
  var fbService = db_firebase_storage().itemRef;

  Controller() {
    // listener
    fbService.snapshots().listen((documents) {
      _shopping_items.clear();
      for (var d in documents.docs) {
        _shopping_items.add(d.data());
      }
      notifyListeners();
    });
  }

  void addItem(Item i) async {
    await fbService.add(i);
  }

  /*void deleteItem(String itemID) {
    _shopping_items.removeWhere((element) => element.id == itemID);
    fbService.deleteItem(itemID);
    notifyListeners();
  }*/

  void find(String department) {
    filterItemList(department);
    notifyListeners();
  }

  List<Item> filterItemList(String? department) {
    if (department != null) {
      List<Item> _filterItemList =
          _shopping_items.where((i) => i.department == department).toList();
      return _filterItemList;
    }
    return _shopping_items;
  }

  int get numberOfItems {
    return _shopping_items.length;
  }
}
