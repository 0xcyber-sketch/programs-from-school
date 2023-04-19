import 'package:flutter/material.dart';
import 'package:shopping_list_project/item.dart';
import 'package:flutter_slidable/flutter_slidable.dart';

Widget ItemListRow(int index) {
  return Slidable(
    key: const ValueKey(0),

    // The end action pane is the one at the right or the bottom side.
    endActionPane: ActionPane(
      dismissible: DismissiblePane(onDismissed: () {}),
      motion: const ScrollMotion(),
      children: const [
        SlidableAction(
          onPressed: null,
          backgroundColor: Color(0xFFFE4A49),
          foregroundColor: Colors.white,
          icon: Icons.delete,
          label: 'Delete',
        )
      ],
    ),

    // The child of the Slidable is what the user sees when the
    // component is not dragged.
    child: ListTile(title: Text('Slide me')),
  );
}

/*


return ListTile(
        leading: Text(item.name),
        
        );,
        title: Text(movie.title),
        subtitle: Text(movie.genre),
        trailing: IconButton(
          onPressed: () {},
          icon: const Icon(Icons.info),
        ));*/