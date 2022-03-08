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
            string a = Console.ReadLine();

            string[] b = new string[2];

            b[0] = a.Split(' ')[0];
            b[1] = a.Split(' ')[1];
            Console.WriteLine(int.Parse(b[0]) + int.Parse(b[1]));
        }
    }
}
