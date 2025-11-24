# README (secciones obligatorias) - Taller 6: Comparación de Ordenación  
**Autores:**

- Marco Orozco
- Wilson Palma

---

## 1. Código fuente
El repositorio debe incluir el código Java instrumentado para los algoritmos y helpers:

- `BubbleSort.java` (implementación con corte temprano y contadores).  
- `SelectionSort.java`.  
- `InsertionSort.java` (contadores de `shifts`).  
- Helpers: `SortingStats.java`, `SortingUtils.java`.  
- Harness: `SortingDemo.java` (ejecuta el experimento y produce `results/resultados_ordenacion.csv`).

**Compilación:**  
`javac -d out src/sorting/*.java`

**Ejecución:**  
`java -cp out sorting.SortingDemo`

---

## 2. Diseño experimental
Parámetros y procedimiento requeridos:

- Repeticiones por algoritmo: `R >= 10` (valor recomendado: `R = 10`).  
- Corridas descartadas: `DISCARD = 3` (las primeras tres corridas se consideran calentamiento/JIT).  
- Estadístico reportado: **mediana** sobre las `R - DISCARD` ejecuciones.  
- Aislamiento de I/O: los archivos CSV se deben cargar **antes** de iniciar las mediciones; únicamente se mide la rutina de ordenación con `System.nanoTime()`.  
- No debe realizarse impresión ni I/O mientras se mide el tiempo.

---

## 3. Datasets obligatorios
Cuatro CSV obligatorios, codificación **UTF-8 sin BOM**, separador **;**, con encabezado en la primera fila y con los nombres exactos:

- `citas_100.csv` — 100 registros (campos: `id;apellido;fechaHora`).  
- `citas_100_casi_ordenadas.csv` — 100 registros (base ordenada por fechaHora con exactamente 5 swaps).  
- `pacientes_500.csv` — 500 registros (campos: `id;apellido;prioridad`; apellidos con sesgo).  
- `inventario_500_inverso.csv` — 500 registros (campos: `id;insumo;stock`; stock = 500..1).

Ubicación: carpeta `datasets/`.

---

## 5. Resultados obligatorios (tabla/CSV)
Archivo resumen obligatorio:

- Ruta y nombre: `resultados_ordenacion.csv`.  
- Cabecera EXACTA (;):  
`dataset;n;algoritmo;median_time_ns;median_comparisons;median_swaps;median_shifts`  
- Contenido: 12 filas de datos (4 datasets × 3 algoritmos) más la cabecera.  
- Este CSV respalda las tablas del informe y se utiliza para análisis posteriores.

---

## 6. Logs / evidencia de ejecución
Registros de ejecución que evidencien las repeticiones:

- Archivo(s) en `logs/`, `logs/salida.txt`.  
- Cada run debe mostrar: número de run, tiempo (ns), `comparisons`, `swaps`, `shifts`.

---

## 7. Verificación final previa a la entrega
Comprobaciones mínimas a documentar:

- `datasets/` contiene los cuatro CSV con los conteos correctos de filas (100 / 100 / 500 / 500).  
- `results/resultados_ordenacion.csv` existe y tiene 13 líneas en total (1 cabecera + 12 datos).  
- `logs/` contiene evidencia de las R ejecuciones por algoritmo y dataset.  
- No hay trazas ni impresiones activas durante las mediciones finales.  
- El harness verifica que los resultados queden ordenados.

---

## 8. Documentación mínima requerida
Notas técnicas del README;

- Valores experimentales documentados: `R`, `DISCARD`, semilla = `42`.  
- Conversión de claves para ordenar: fecha → epoch-minutes; apellido → mapeo entero estable; stock → entero.  
- Contadores registrados: `comparisons`, `swaps`, `shifts` (Insertion). Tiempo medido en nanosegundos (`System.nanoTime()`).  
- Indicador de que la medición excluye I/O.