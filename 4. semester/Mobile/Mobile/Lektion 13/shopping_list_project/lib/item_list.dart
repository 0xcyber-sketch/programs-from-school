import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:shopping_list_project/add_item_page.dart';
import 'package:shopping_list_project/controller.dart';
import 'package:shopping_list_project/item.dart';

import 'item_list_row.dart';

class ItemList extends StatefulWidget {
  const ItemList({Key? key}) : super(key: key);

  @override
  State<ItemList> createState() => _ItemListState();
}

class _ItemListState extends State<ItemList> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text('Shopping List')),
        body: Consumer<Controller>(
          builder: (context, _itemController, widget) {
            return Container(
                child: ListView.separated(
                    itemCount: _itemController.numberOfItems,
                    separatorBuilder: (context, index) => Divider(),
                    itemBuilder: (context, index) {
                      final Item item =
                          _itemController.filterItemList(null)[index];

                      return ItemListRow(index);
                    }));
          },
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: (() => {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => const AddItemFormRoute()))
              }),
          child: const Icon(Icons.add),
        ));
  }
}
