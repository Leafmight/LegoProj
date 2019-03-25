package Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class BandCalculator {

    public int[] calculateBricks(int width, int length, int height, int bandType) {
        int x4 = 0;
        int x2 = 0;
        int x1 = 0;

        int[] list = new int[6];

        list[0] = x4;
        list[1] = x2;
        list[2] = x1;
        list[3] = x4;
        list[4] = x2;
        list[5] = x1;

        switch (bandType) {
            case 1:
                if (width < 4) {
                    list[0] = 0;
                }
                if (width % 4 == 0) {
                    list[0] = (width / 4) * 2 * height;
                }
                if (width > 4) {
                    list[0] = ((width - (width % 4)) / 4) * 2 * height;
                }
                if ((width % 4) == 2) {
                    list[1] = 1 * 2 * height;
                }
                if (width % 4 == 1) {
                    list[2] = 1 * 2 * height;
                }
                if (width % 4 > 2) {
                    list[1] = 1 * 2 * height;
                    list[2] = 1 * 2 * height;
                }
                if (length < 4) {
                    list[3] = 0;
                }
                if (length % 4 == 0) {
                    list[3] = (length / 4) * 2 * height;
                }
                if (length > 4) {
                    list[3] = ((length - (length % 4)) / 4) * 2 * height;
                }
                if ((length % 4) == 2) {
                    list[4] = 1 * 2 * height;
                }
                if (length % 4 == 1) {
                    list[5] = 1 * 2 * height;
                }
                if (length % 4 > 2) {
                    list[4] = 1 * 2 * height;
                    list[5] = 1 * 2 * height;

                }
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                break;
            default:
                throw new AssertionError();
        }
        return list;
    }

}
