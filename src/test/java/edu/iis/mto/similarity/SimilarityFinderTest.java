package edu.iis.mto.similarity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SimilarityFinderTest {

    @Test public void SimilarityFinderTestGoodValue(){
        SimilarityFinder similarityFinder = new SimilarityFinder();
        int seq1[] = {1,2,3,4,5,6};
        int seq2[] = {5,4,6,7,8,9};
        Assertions.assertEquals(0.5, similarityFinder.calculateJackardSimilarity(seq1,seq2));
    }

    @Test public void SimilarityFinderTestSWithSequencesLenZero(){
        SimilarityFinder similarityFinder = new SimilarityFinder();
        int seq1[] = {};
        int seq2[] = {};
        Assertions.assertEquals(1.0, similarityFinder.calculateJackardSimilarity(seq1,seq2));
    }

    @Test public void SimilarityFinderTestValueEqualOneWithTheSameSequences(){
        SimilarityFinder similarityFinder = new SimilarityFinder();
        int seq1[] = {1,2,3};
        int seq2[] = {1,2,3};
        Assertions.assertEquals(1.0, similarityFinder.calculateJackardSimilarity(seq1,seq2));
    }

    @Test public void SimilarityFinderTestValueEqualZeroWithDifferentSequences(){
        SimilarityFinder similarityFinder = new SimilarityFinder();
        int seq1[] = {1,2,3};
        int seq2[] = {6,7,9};
        Assertions.assertEquals(0.0, similarityFinder.calculateJackardSimilarity(seq1,seq2));
    }
}