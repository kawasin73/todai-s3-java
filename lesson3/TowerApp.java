class TowerApp {

    public static void doTowers(int topN, char from, char to, char inter) {
        if (topN == 0) {
            System.out.println("invalid num 0");
            return;
        } else if (topN == 1) {
            move(1, from, to);
            return;
        }
        doTowers(topN - 1, from, inter, to);
        move(topN, from, to);
        doTowers(topN - 1, inter, to, from);
    }

    public static void move(int num, char from, char to) {
        System.out.println(String.format("Move disk %d from %c to %c", num, from, to));
    }
}
