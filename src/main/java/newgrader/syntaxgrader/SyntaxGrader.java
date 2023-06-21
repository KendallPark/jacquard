package newgrader.syntaxgrader;

import com.github.javaparser.ast.CompilationUnit;
import newgrader.common.*;

import java.util.List;

/**
 * Syntax-based graders that make use of the linked
 * <a href="https://javaparser.org/">Java parser</a>.
 */
public abstract class SyntaxGrader extends Grader {
    public SyntaxGrader(String name) {
        super(name);
    }

    @Override
    public List<Result> grade(Target target) {
        return grade(target.toCompilationUnit());
    }

    public abstract List<Result> grade(CompilationUnit cu);

    /**
     * The maximum possible score achievable with this grader.
     *
     * @return the maximum possible score
     */
    public abstract double getTotalMaxScore();
}
