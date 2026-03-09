public class Task3c {
    public void main (String[] args)
    {
        int num = 1;
        for (int i = 1 ; i <= 5 ;i++)
        {
            num = i;
            for (int j = 0 ; j < 5 ; j++)
            {
                System.out.print((num++)+ " ");
            }
            System.out.println();
        }
    }
}
