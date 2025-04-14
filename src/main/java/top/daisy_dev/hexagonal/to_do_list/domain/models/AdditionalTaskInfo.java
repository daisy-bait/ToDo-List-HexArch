package top.daisy_dev.hexagonal.to_do_list.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * Aquí podemos ver la inmutabilidad, propiedad de los objetos que, una vez creados, no pueden ser modificados.
 * Estructuras de datos inmutables no permiten cambios en su contenido después de ser creadas.
 *
 * Esto proporciona:
 * <ol>
 *     <li>Escalabilidad</li>
 *     <li>Facilita el razonamiento del código</li>
 *     <li>Reduce errores</li>
 *     <li>Puede mejorar el rendimiento en entornos concurrentes (?)</li>
 * </ol>
 */
@AllArgsConstructor
@Getter
public class AdditionalTaskInfo {

    private final Long userId;
    private final String userName;
    private final String userEmail;
    private final String taskName;
    private final boolean completed;

}
