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

    @Test public void calculateJackardSimilarityTestWithOneSeqLongerAndTheSameElements(){
        SequenceSearcher sequenceSearcher = (key, seq) -> {
            if(key <= 10) {
                SearchResult.Builder builder = SearchResult.builder();
                builder.withFound(true);
                return builder.build();
            } else {
                SearchResult.Builder builder = SearchResult.builder();
                builder.withFound(false);
                return builder.build();
            }
        };
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        int seq1[] = {1,2,3,4,5,6};
        int seq2[] = {1,2,3};
        double delta = 0.01;

        Assertions.assertEquals(2.0, similarityFinder.calculateJackardSimilarity(seq1,seq2),delta);
    }

    @Test public void calculateJackardSimilarityTestWithDifferentElements(){
        SequenceSearcher sequenceSearcher = (key, seq) -> {
                SearchResult.Builder builder = SearchResult.builder();
                builder.withFound(false);
                return builder.build();
        };
        SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcher);

        int seq1[] = {6,7,8,9};
        int seq2[] = {1,2,3};
        double delta = 0.01;

        Assertions.assertEquals(0.0, similarityFinder.calculateJackardSimilarity(seq1,seq2),delta);
    }

}