//  Compile with:
//  	gcc desPinF.c -o desPinF
#include	<stdlib.h>
#include	<stdio.h>

const unsigned int	B01	= 0x80000000;
const unsigned int	B02	= 0x40000000;
const unsigned int	B03	= 0x20000000;
const unsigned int	B04	= 0x10000000;
const unsigned int	B05	= 0x08000000;
const unsigned int	B06	= 0x04000000;
const unsigned int	B07	= 0x02000000;
const unsigned int	B08	= 0x01000000;
const unsigned int	B09	= 0x00800000;
const unsigned int	B10	= 0x00400000;
const unsigned int	B11	= 0x00200000;
const unsigned int	B12	= 0x00100000;
const unsigned int	B13	= 0x00080000;
const unsigned int	B14	= 0x00040000;
const unsigned int	B15	= 0x00020000;
const unsigned int	B16	= 0x00010000;
const unsigned int	B17	= 0x00008000;
const unsigned int	B18	= 0x00004000;
const unsigned int	B19	= 0x00002000;
const unsigned int	B20	= 0x00001000;
const unsigned int	B21	= 0x00000800;
const unsigned int	B22	= 0x00000400;
const unsigned int	B23	= 0x00000200;
const unsigned int	B24	= 0x00000100;
const unsigned int	B25	= 0x00000080;
const unsigned int	B26	= 0x00000040;
const unsigned int	B27	= 0x00000020;
const unsigned int	B28	= 0x00000010;
const unsigned int	B29	= 0x00000008;
const unsigned int	B30	= 0x00000004;
const unsigned int	B31	= 0x00000002;
const unsigned int	B32	= 0x00000001;

unsigned int	permute		(unsigned int	u
				)
{
  unsigned int	result	= 0;

  result	|= ((u & B16) ? 1 : 0) << 31;
  result	|= ((u & B07) ? 1 : 0) << 30;
  result	|= ((u & B20) ? 1 : 0) << 29;
  result	|= ((u & B21) ? 1 : 0) << 28;
  result	|= ((u & B29) ? 1 : 0) << 27;
  result	|= ((u & B12) ? 1 : 0) << 26;
  result	|= ((u & B28) ? 1 : 0) << 25;
  result	|= ((u & B17) ? 1 : 0) << 24;

  result	|= ((u & B01) ? 1 : 0) << 23;
  result	|= ((u & B15) ? 1 : 0) << 22;
  result	|= ((u & B23) ? 1 : 0) << 21;
  result	|= ((u & B26) ? 1 : 0) << 20;
  result	|= ((u & B05) ? 1 : 0) << 19;
  result	|= ((u & B18) ? 1 : 0) << 18;
  result	|= ((u & B31) ? 1 : 0) << 17;
  result	|= ((u & B10) ? 1 : 0) << 16;

  result	|= ((u & B02) ? 1 : 0) << 15;
  result	|= ((u & B08) ? 1 : 0) << 14;
  result	|= ((u & B24) ? 1 : 0) << 13;
  result	|= ((u & B14) ? 1 : 0) << 12;
  result	|= ((u & B32) ? 1 : 0) << 11;
  result	|= ((u & B27) ? 1 : 0) << 10;
  result	|= ((u & B03) ? 1 : 0) <<  9;
  result	|= ((u & B09) ? 1 : 0) <<  8;

  result	|= ((u & B19) ? 1 : 0) <<  7;
  result	|= ((u & B13) ? 1 : 0) <<  6;
  result	|= ((u & B30) ? 1 : 0) <<  5;
  result	|= ((u & B06) ? 1 : 0) <<  4;
  result	|= ((u & B22) ? 1 : 0) <<  3;
  result	|= ((u & B11) ? 1 : 0) <<  2;
  result	|= ((u & B04) ? 1 : 0) <<  1;
  result	|= ((u & B25) ? 1 : 0) <<  0;

  return(result);
}


int		main		()
{
  char		text[80];
  unsigned int	u;

  printf("Please enter the DES S-box output in hexadecimal (with the 0x): ");
  fgets(text,80,stdin);
  u	= strtol(text,NULL,0);

  printf("permute(0x%X) = 0x%X\n",u,permute(u));
  return(EXIT_SUCCESS);
}
