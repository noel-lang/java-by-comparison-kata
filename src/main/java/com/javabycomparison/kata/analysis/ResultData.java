package com.javabycomparison.kata.analysis;

import java.util.StringJoiner;

public class ResultData {

	public int type;
	public String name;
	public int linesOfCode;
	public int linesOfComments;
	public int linesOfMethods;
	public int linesOfImports;

	public ResultData(int type, String name, int linesOfCode, int linesOfComments, int linesOfMethods, int linesOfImports) {
		this.type = type;
		this.name = name.replaceAll("\\\\", "/");
		this.linesOfCode = linesOfCode;
		this.linesOfComments = linesOfComments;
		this.linesOfMethods = linesOfMethods;
		this.linesOfImports = linesOfImports;
	}

	public ResultData() {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;
		ResultData that = (ResultData) o;
		return type == that.type
				&& linesOfCode == that.linesOfCode
				&& linesOfComments == that.linesOfComments
				&& linesOfMethods == that.linesOfMethods
				&& linesOfImports == that.linesOfImports
				&& name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "ResultData{" +
				"type=" + type +
				", name='" + name + '\'' +
				", linesOfCode=" + linesOfCode +
				", linesOfComments=" + linesOfComments +
				", linesOfMethods=" + linesOfMethods +
				", linesOfImports=" + linesOfImports +
				'}';
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLinesOfCode() {
		return linesOfCode;
	}

	public void setLinesOfCode(int linesOfCode) {
		this.linesOfCode = linesOfCode;
	}

	public int getLinesOfComments() {
		return linesOfComments;
	}

	public void setLinesOfComments(int linesOfComments) {
		this.linesOfComments = linesOfComments;
	}

	public int getLinesOfMethods() {
		return linesOfMethods;
	}

	public void setLinesOfMethods(int linesOfMethods) {
		this.linesOfMethods = linesOfMethods;
	}

	public int getLinesOfImports() {
		return linesOfImports;
	}

	public void setLinesOfImports(int linesOfImports) {
		this.linesOfImports = linesOfImports;
	}
}
