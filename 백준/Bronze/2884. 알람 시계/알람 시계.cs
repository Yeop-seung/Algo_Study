using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaekJun_Study
{
    internal class Program
    {
        static void Main()
        {
            string[] a = new string[2];
            while (true)
            {
                string temp = Console.ReadLine();
                a[0] = temp.Split(' ')[0];
                a[1] = temp.Split(' ')[1];
                if (int.Parse(a[0]) >= 0 && int.Parse(a[0]) < 24)
                {
                    int c = int.Parse(a[0]);
                    if(int.Parse(a[1]) >= 0 && int.Parse(a[1]) < 60)
                    {
                        int b = int.Parse(a[1]);
                        for (int i = 0; i < 45; i++)
                        {
                            if (b == 0)
                            {
                                b = 59;
                                if (c == 0)
                                {
                                    c = 23;
                                }
                                else
                                c--;

                            }
                            else
                            b--;
                        }
                        a[0] = c.ToString();
                        a[1] = b.ToString();
                        break;
                    }
                    else
                    {
                        continue;
                    }
                }
                else
                {
                    continue;
                }
            }
            Console.WriteLine(int.Parse(a[0]) + " " + int.Parse(a[1]));
        }
    }
}
