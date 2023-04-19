import 'package:http/http.dart' as http;
import 'dart:convert';

class NetworkService {
  dynamic fetchJSONFrom({required String url}) async {
    final uri = Uri.parse(url);
    final res = await http.get(uri);
    if (res.statusCode == 200) {
      return json.decode(res.body);
    }
  }
}
