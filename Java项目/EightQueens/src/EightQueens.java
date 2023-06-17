public class EightQueens {
    public static void main(String[] args)
    {
        //创建一个棋盘
        var chess1 = new Chess();

        //第一行的棋子从1到8列摆放
        for (int i = 1; i < 9; i++)
        {
            chess1.cls();
            chess1.rule(1, i);
            chess1.下棋(2);
            System.out.println("当第一枚棋子放在第" + i + "列时，八皇后共有" + chess1.solution1 + "中解法。");
            chess1.solution1 = 0;
        }
        System.out.println("八皇后共有" + chess1.solution2 + "中解法。");
    }
}

class Chess {
    int solution1 = 0;//计算解法种数
    int solution2 = 0;
    private int[][] chess = new int[9][9];

    //初始化棋盘（清空）
    public void cls()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                chess[i][j] = 1;
            }
        }
    }

    //每一枚棋子的行，列，斜，都不能有其他棋子。
    public void rule(int row, int column)
    {
        //0表示该位置不可被占据
        //行，列被标记
        for (int i = 1; i < 9; i++)
        {
            chess[row][i]--;
            chess[i][column]--;

        }
        //斜被标记
        for (int i = 1; i < 9; i++)
        {
            if (row + i < 9)
            {
                if (column - i > 0)
                {
                    chess[row + i][column - i]--;
                }
                if (column + i < 9)
                {
                    chess[row + i][column + i]--;
                }
            }
            if (row - i > 0)
            {
                if (column - i > 0)
                {
                    chess[row - i][column - i]--;
                }
                if (column + i < 9)
                {
                    chess[row - i][column + i]--;
                }
            }
        }
        chess[row][column] = 2;
    }

    public void clsrule(int row, int column)
    {
        //0表示该位置不可被占据
        //行，列取消标记
        for (int i = 1; i < 9; i++)
        {
            chess[row][i]++;
            chess[i][column]++;

        }
        //斜取消标记
        for (int i = 1; i < 9; i++)
        {
            if (row + i < 9)
            {
                if (column - i > 0)
                {
                    chess[row + i][column - i]++;
                }
                if (column + i < 9)
                {
                    chess[row + i][column + i]++;
                }
            }
            if (row - i > 0)
            {
                if (column - i > 0)
                {
                    chess[row - i][column - i]++;
                }
                if (column + i < 9)
                {
                    chess[row - i][column + i]++;
                }
            }
        }
        chess[row][column] = 1;
    }

    //从第2行开始寻找八皇后的正确摆法
    public void 下棋(int row)
    {
        for (int column = 1; column < 9; column++)
        {
            //当该位置未被占据和标记时
            if (chess[row][column] == 1)
            {
                rule(row, column);//标记并下棋
                if (row < 8)//该行已正确下棋，进入下一行
                {
                    下棋(row + 1);
                }
                if (row == 8)//最后一行
                {
                    //此时，八皇后已下完，寻到一个完整的解法
                    for (int new_row = 0; new_row < 9; new_row++)
                    {
                        for (int new_column = 0; new_column < 9; new_column++)
                        {
                            if (chess[new_row][new_column] == 2)
                            {
                                System.out.print("Q ");
                            } else
                            {
                                System.out.print("- ");
                            }
                        }
                        System.out.println();
                    }
                    //分隔棋盘
                    System.out.println("\n");
                    solution1++;
                    solution2++;
                }
                //清除该种解法的标记
                clsrule(row, column);
            }
        }
    }


}