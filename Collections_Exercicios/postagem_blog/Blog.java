import java.util.*;
import java.util.stream.Collectors;

public class Blog {
    private Set<Post> postagens = new HashSet<>();

    public void adicionarPostagem(Post Post) {
        for (Post p : postagens) {
            if (p.getAutor().equals(Post.getAutor()) && p.getTitulo().equals(Post.getTitulo())) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }
        postagens.add(Post);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = postagens.stream()
            .map(Post::getAutor)
            .collect(Collectors.toCollection(LinkedHashSet::new));
        List<Autor> lista = new ArrayList<>(autores);
        Collections.reverse(lista);
        return new LinkedHashSet<>(lista);
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new HashMap<>();
        for (Post p : postagens) {
            Categorias cat = p.getCategoria();
            contagem.put(cat, contagem.getOrDefault(cat, 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        return postagens.stream()
                .filter(p -> p.getAutor().getNome().equals(autor.getNome()) && p.getAutor().getSobrenome().equals(autor.getSobrenome()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        return postagens.stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .sorted(Comparator.comparing(Post::getTitulo))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> map = new HashMap<>();
        for (Post p : postagens) {
            map.computeIfAbsent(p.getCategoria(), k -> new TreeSet<>(Comparator.comparing(Post::getTitulo)))
               .add(p);
        }
        return map;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> map = new HashMap<>();
        for (Post p : postagens) {
            map.computeIfAbsent(p.getAutor(), k -> new TreeSet<>(Comparator.comparing(Post::getTitulo)))
               .add(p);
        }
        return map;
    }
}
