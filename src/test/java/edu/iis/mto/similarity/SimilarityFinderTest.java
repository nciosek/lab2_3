package edu.iis.mto.similarity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimilarityFinderTest {
    SequenceSearcherDubler sequenceSearcherDubler = new SequenceSearcherDubler();
    SimilarityFinder similarityFinder = new SimilarityFinder(sequenceSearcherDubler);

    private double calculateResult(int[] seq1, int[] seq2) {
        int numberOfTheSameValues = similarityFinder.calculateIntersect(seq1, seq2);
        double result = (double) numberOfTheSameValues / (seq1.length + seq2.length - numberOfTheSameValues);
        return result;
    }

    @Test public void SimilarityFinderTestGoodValue(){
        int seq1[] = {1,2,3,4,5,6};
        int seq2[] = {5,4,6,7,8,9};
        double delta = 0.01;
        double result = calculateResult(seq1,seq2);

        Assertions.assertEquals(result, similarityFinder.calculateJackardSimilarity(seq1,seq2), delta);
    }

    @Test public void SimilarityFinderTestSWithSequencesLenZero(){
        int seq1[] = {};
        int seq2[] = {};
        double delta = 0.01;

        Assertions.assertEquals(1.0, similarityFinder.calculateJackardSimilarity(seq1,seq2), delta);
    }

    @Test public void SimilarityFinderTestValueEqualOneWithTheSameSequences(){
        int seq1[] = {1,2,3};
        int seq2[] = {1,2,3};
        double delta = 0.01;

        Assertions.assertEquals(1.0, similarityFinder.calculateJackardSimilarity(seq1,seq2), delta);
    }

    @Test public void SimilarityFinderTestValueEqualZeroWithDifferentSequences(){
        int seq1[] = {1,2,3};
        int seq2[] = {6,7,9};
        double delta = 0.01;

        Assertions.assertEquals(0.0, similarityFinder.calculateJackardSimilarity(seq1,seq2), delta);
    }

    @Test public void SimilarityFinderTestDifferentLengthElementsSequences(){
        int seq1[] ={1,2,3};
        int seq2[] = {1,2,3,6,7};
        double delta = 0.01;
        double result = calculateResult(seq1,seq2);

        Assertions.assertEquals(result, similarityFinder.calculateJackardSimilarity(seq1,seq2), delta);
    }

    @Test public void SimilarityFinderTestWithNegativeNumber(){
        int seq1[] = {-1, -2, -3};
        int seq2[] = {-4, -1, -5, -9};
        double delta = 0.01;
        double result = calculateResult(seq1,seq2);

        Assertions.assertEquals(result, similarityFinder.calculateJackardSimilarity(seq1,seq2), delta);
    }
}