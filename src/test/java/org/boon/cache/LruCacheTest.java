package org.boon.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.boon.Exceptions.die;

/**
 * Created by rick on 12/17/13.
 */
public class LruCacheTest {
    @Before
    public void setUp () throws Exception {

    }

    @After
    public void tearDown () throws Exception {

    }

    @Test
    public void test () {
        LruCache<Integer, Integer> cache = new LruCache<> ( 4 );


        cache.put ( 0, 0 );
        cache.put ( 1, 1 );

        cache.put ( 2, 2 );
        cache.put ( 3, 3 );


        boolean ok = cache.size () == 4 || die ( "size" + cache.size () );
        ok |= cache.getSilent ( 0 ) == 0 || die ();
        ok |= cache.getSilent ( 3 ) == 3 || die ();


        cache.put ( 4, 4 );
        cache.put ( 5, 5 );
        ok |= cache.size () == 4 || die ( "size" + cache.size () );
        ok |= cache.getSilent ( 0 ) == null || die ();
        ok |= cache.getSilent ( 1 ) == null || die ();
        ok |= cache.getSilent ( 2 ) == 2 || die ();
        ok |= cache.getSilent ( 3 ) == 3 || die ();
        ok |= cache.getSilent ( 4 ) == 4 || die ();
        ok |= cache.getSilent ( 5 ) == 5 || die ();

        if ( !ok ) die ();

    }
}