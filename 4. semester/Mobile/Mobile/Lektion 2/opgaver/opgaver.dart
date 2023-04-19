// Opgave 1

double calculate(double width, double height) {
  return width * height;
}

// Opgave 2

double calculate2(
    {double width = 2, double height = 2, bool isTriangle = false}) {
  if (isTriangle) {
    return (width * height) / 2;
  }
  return width * height;
}

// Opgave 3
String reverse(String old) {
  var newS = "";
  for (int i = old.length - 1; i >= 0; i--) {
    newS += old.substring(i, i + 1);
  }
  return newS;
}

// Opgave 4

bool isPalindrome(String canditate) {
  if (reverse(canditate) == canditate) {
    return true;
  }
  return false;
}

void main() {
  print(calculate(8, 12));

  print(calculate2(height: 8, width: 12, isTriangle: true));

  print(reverse("hello"));

  print(isPalindrome("bob"));
}
