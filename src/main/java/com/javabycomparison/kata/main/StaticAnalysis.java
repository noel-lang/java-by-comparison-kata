package com.javabycomparison.kata.main;

import com.javabycomparison.kata.analysis.ResultData;
import com.javabycomparison.kata.analysis.ResultDataPrinter;
import com.javabycomparison.kata.printing.CSVPrinter;
import com.javabycomparison.kata.printing.ResultPrinter;
import com.javabycomparison.kata.search.SearchClient;

import java.io.IOException;
import java.util.LinkedList;

public class StaticAnalysis {

	public static void main(String... args) {
		analyze(args.length == 0 ? null : args[0], args.length == 2 && args[1].equals("withSummary"));
	}

	private static void analyze(String p, boolean withSummary) {
		StaticAnalysis analyzer = new StaticAnalysis();
		ResultData[] overallResult = analyzer.run(p == null ? "./src/" : p, withSummary);

		if (overallResult == null) {
			System.err.println("Something went terribly wrong");
			return;
		}

		ResultPrinter.printOverallResults(overallResult);

		try {
			new CSVPrinter("output.csv").writeCSV(overallResult);
		} catch (IOException e) {
			System.err.println("Couldn't write output to file, abort...");
		}
	}

	private ResultData[] run(String directoryPath, boolean withSummary) {
		LinkedList<ResultData> results = new SearchClient(withSummary).collectAllFiles(directoryPath);
		if (results != null) {
			if (results.size() != 0) {
				int javaLOC = 0;
				int javaCommentLOC = 0;
				int javaNumMethod = 0;
				int javanImports = 0;

				int pyLOC = 0;
				int pyCommentLOC = 0;
				int pyNumMethod = 0;
				int pynImports = 0;

				int LOC = 0;
				int commentLOC = 0;
				int numMethod = 0;
				int nImports = 0;

				for (ResultData resultData : results) {
					if (!withSummary) {
						System.out.println(new ResultDataPrinter().print(resultData));
					}
					if (resultData.type == 0) {
						javaLOC += resultData.linesOfCode;
						javaCommentLOC += resultData.linesOfComments;
						javaNumMethod += resultData.linesOfMethods;
						javanImports += resultData.linesOfImports;
					} else if (resultData.type == 1) {
						pyLOC += resultData.linesOfCode;
						pyCommentLOC += resultData.linesOfComments;
						pyNumMethod += resultData.linesOfMethods;
						pynImports += resultData.linesOfImports;
					} else {
						LOC += resultData.linesOfCode;
						commentLOC += resultData.linesOfComments;
						numMethod += resultData.linesOfMethods;
						nImports += resultData.linesOfImports;
					}
				}
				return new ResultData[]{
						new ResultData(0, "Overall Java", javaLOC, javaCommentLOC, javaNumMethod, javanImports),
						new ResultData(1, "Overall Python", pyLOC, pyCommentLOC, pyNumMethod, pynImports),
						new ResultData(2, "Overall Other", LOC, commentLOC, numMethod, nImports),
				};
			} else {
				return new ResultData[]{ new ResultData() };
			}
		}

		System.err.println("There was a problem with the result!");

		return null;
	}
}
