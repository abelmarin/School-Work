// Abel Marin

#include <stdio.h>
#include <stdlib.h>
#include <getopt.h>
#include "cachelab.h"

// globals
int lines_per_set;

void printUsage()
{
	printf( "Usage: csim [-hv] -s <s> -E <E> -b <b> -t <tracefile>\n" );
}

int main( int argc, char * argv[] )
{
	// using getopt(), parse the command line arguments
	char * filename= NULL;
	int option;
	char verbose= 0;
	lines_per_set= 0;
	int s_bits= 0, block_bits= 0, tag_bits= 0;
	while ( (option= getopt( argc, argv, "hvs:E:b:t:" )) != -1 )
	{
		switch( option )
		{
		case 'h':
			printUsage();
			exit(EXIT_SUCCESS);
			break;
		case 'v':
			verbose= 1;
			break;
		case 's':
			s_bits= atoi( optarg );
			break;
		case 'E':
			lines_per_set= atoi( optarg );
			break;
		case 'b':
			block_bits= atoi( optarg );
			break;
		case 't':
			filename= optarg;
			break;
		default:
			printf( "Unknown option encountered\n" );
			printUsage();
			exit(EXIT_FAILURE);
		}		
	}
	if ( s_bits == 0 || lines_per_set == 0 || block_bits == 0 )
	{
		printf( "Value for cache parameter not passed on command line\n" );
		printUsage();
		exit(EXIT_FAILURE);
	}
	
	// compute the number of tag bits
	
	// allocate the cache
	
	// zero out the cache
	
	// initialize the time variable
	
	// open the trace file
	
	int hit_total= 0, miss_total= 0, eviction_total= 0;
	
	// read each line in the trace file
	//   if the line represents an instruction
	//     skip over it
	//   compute the set and tag bits
	//   if the data exists in the cache
	//     increment counter(s) and update the entry time
	//   else
	//     get the next free line in the set
	//     if no free line exists, evict a line using the LRU algorithm
	//     place the data in the cache and set the entry time
	//     increment counter(s)
	
	// close the file
	
	// free the cache
	
	printSummary( hit_total, miss_total, eviction_total );
	
    return 0;
}
