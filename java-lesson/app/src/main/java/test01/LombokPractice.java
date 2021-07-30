package test01;

class Store {
  String name;
  String location;
  double lat, lng;
  String menu;
  String score;

  public Store(String name, String location, double lat, double lng) {
    this.name = name;
    this.location = location;
    this.lat = lat;
    this.lng = lng;
  }

  public void print() {
    System.out.println(name);
    System.out.println(this.location);
    System.out.println(this.lat);
    System.out.println(this.lng);
  }

}
class LombokPractice {
  public static void main(String[] args) {
    Store store = new Store();
    store.print();
  }
}
