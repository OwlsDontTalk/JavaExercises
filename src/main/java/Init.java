public class Init {
    public static void main(String[] args) {
        double aLittleLess = 1.01;
        double aLittleMore = 0.99;

        for(int i = 0 ; i < 365; i++){
            aLittleLess *= aLittleLess;
            aLittleMore *= aLittleMore;
        }

        System.out.println(aLittleLess);
        System.out.println(aLittleMore);
    }
}
