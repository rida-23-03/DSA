class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] s1=new HashSet[9];//rows
        HashSet<Character>[] s2=new HashSet[9];//cols
        HashSet<Character>[] s3=new HashSet[9];//3*3 boxes

        for(int i=0;i<9;i++){
            s1[i]=new HashSet<>();//for each row cols and boxes
            s2[i]=new HashSet<>();
            s3[i]=new HashSet<>();
        }

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                char num=board[r][c];
                if(num=='.'){
                    continue;
                }
                int box=(r/3)*3+(c/3);

                if(s1[r].contains(num)||s2[c].contains(num)||
                   s3[box].contains(num)){
                        return false;
                }
                s1[r].add(num);
                s2[c].add(num);
                s3[box].add(num);
            }
        }
        return true;

    }
}
