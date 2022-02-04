<?php
for ($i = 0; $i < 3; $i++) {
    echo strlen( "123" );
}

function get_num(int $s1, int $s2): int
{
    return $s1 - $s2;
}

$num = get_num( 1, 2 );

echo $num;
