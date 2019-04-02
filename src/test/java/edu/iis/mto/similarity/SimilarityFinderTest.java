package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimilarityFinderTest {

    @Test public void calculateJackardSimilarityTestValueEqualOneWithTheSameSequences(){
        SequenceSearcher sequenceSearcher = (key, seq) -> {
            SearchResult.Builder builder = SearchResult.builder();
            builder.withFound(true);
            return builder.build();
        };
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        int seq1[] = {1,2,3};
        int seq2[] = {1,2,3};
        double delta = 0.01;

        Assertions.assertEquals(1.0, similarityFinder.calculateJackardSimilarity(seq1, seq2), delta);
    }
}