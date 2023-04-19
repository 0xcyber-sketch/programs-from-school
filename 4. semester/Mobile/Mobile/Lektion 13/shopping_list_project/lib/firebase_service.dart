import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:shopping_list_project/item.dart';

class db_firebase_storage {
  final FirebaseFirestore firestore = FirebaseFirestore.instance;
  final String collection = "Shopping_List";

  final itemRef = FirebaseFirestore.instance
      .collection("Shopping_List")
      .withConverter<Item>(
        fromFirestore: (snapshot, _) {
          return Item.fromMap(snapshot.data()!, snapshot.id);
        },
        toFirestore: (item, _) => item.toMap(),
      );

  add(Item item) async {
    await itemRef.add(item);
  }

  delete(String id) async {
    await itemRef.doc(id).delete();
  }
}
