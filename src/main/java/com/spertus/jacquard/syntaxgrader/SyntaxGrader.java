package com.spertus.jacquard.syntaxgrader;

import com.github.javaparser.ast.CompilationUnit;
import com.spertus.jacquard.common.*;

import java.util.List;

/**
 * Syntax-based graders that make use of the linked
 * <a href="https://javaparser.org/">Java parser</a>.
 */
public abstract class SyntaxGrader extends Grader {
    /**
     * Constructs a syntax-based grader.
     *
     * @param name the name
     */
    public SyntaxGrader(String name) {
        super(name);
    }

    @Override
    public List<Result> grade(Target target) {
        return grade(target.toCompilationUnit());
    }

    /**
     * Grades the parsed compilation unit.
     *
     * @param cu the parsed compilation unit
     * @return the results
     */
    protected abstract List<Result> grade(CompilationUnit cu);

    /**
     * The maximum possible score achievable with this grader.
     *
     * @return the maximum possible score
     */
    public abstract double getTotalMaxScore();
}