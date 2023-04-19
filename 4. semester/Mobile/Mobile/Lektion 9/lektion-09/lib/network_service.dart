import 'dart:convert';

import 'package:flutter/services.dart' show rootBundle;

class NetworkService {
  static Future<List<Map<String, dynamic>>> loadJSONData() async {
    var jsonTxet = await rootBundle
        .loadString('assets/json/Movies.json'); // læs json fr filesystem
    List<Map<String, dynamic>> data =
        json.decode(jsonTxet).cast<Map<String, dynamic>>();

    return data;
  }
}
