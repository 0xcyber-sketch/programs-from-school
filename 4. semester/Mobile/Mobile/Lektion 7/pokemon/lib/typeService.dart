class typeService {
  convertTypeToColor(String type) {
    switch (type) {
      case "normal":
        return "0xFFC6C0BB";
      case "fire":
        return "0xFFE43A0D";
      case "water":
        return "0xFF3191F0";
      case "grass":
        return "0xFF6DBF31";
      case "ice":
        return "0xFF9EE5FF";
      case "ghost":
        return "0xFF5D5EAB";
      case "fighting":
        return "0xFF7E3219";
      case "flying":
        return "0xFF859AEA";
      case "psychic":
        return "0xFFEA437D";
      case "poison":
        return "0xFF914493";
      case "bug":
        return "0xFF88980F";
      case "dark":
        return "0xFF4F3A2D";
      case "steel":
        return "0xFFB2B2BF";
      case "fairy":
        return "0xFFE9A5EC";
      case "rock":
        return "0xFFB49D4E";
      case "ground":
        return "0xFFD5B35D";
      case "electric":
        return "0xFFF0AB17";
      case "dragon":
        return "0xFF745DDD";
      case "unknown":
        return "0xFF1C9C88";
      case "shadow":
        return "0xFF5D5EAB";
      default:
        return "Error";
    }
  }
}
