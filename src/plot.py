import matplotlib.pyplot as plt

output_folder =  "D:\\Folder F\\phamtuananh@23020010\\My Study\\Year2526\\Semester II\\Testing\\CREDIT\\src\\figure"

def read_data(path):
    data = []
    with open(path, "r", encoding="utf-8") as f:
        for line in f:
            parts = line.strip().split(",")
            if len(parts) == 3:
                name, expected, actual = parts
                data.append((name, expected, actual))
    return data


def analyze(data):
    total = len(data)
    pass_count = 0
    fail_count = 0

    result_dist = {}

    for name, expected, actual in data:
        if expected == actual:
            pass_count += 1
        else:
            fail_count += 1

        # thống kê kết quả thực tế
        result_dist[actual] = result_dist.get(actual, 0) + 1

    return total, pass_count, fail_count, result_dist


def plot_pass_fail(pass_count, fail_count):
    plt.figure(figsize=(8, 6))  # tăng kích thước

    plt.bar(["Pass", "Fail"], [pass_count, fail_count])

    plt.title("Test Results (Pass vs Fail)", fontsize=16)
    plt.xlabel("Status", fontsize=20)
    plt.ylabel("Count", fontsize=20)
    plt.xticks(fontsize=18)
    plt.yticks(fontsize=18)

    plt.savefig(f"{output_folder}\\pass_fail.png", dpi=300)
    plt.show()


def plot_distribution(result_dist):
    plt.figure(figsize=(8, 6))

    labels = list(result_dist.keys())
    values = list(result_dist.values())

    plt.bar(labels, values)

    plt.title("Result Distribution", fontsize=16)
    plt.xlabel("Result Type", fontsize=20)
    plt.ylabel("Count", fontsize=20)
    plt.xticks(fontsize=16)
    plt.yticks(fontsize=18)

    plt.savefig(f"{output_folder}\\result_distribution.png", dpi=300)
    plt.show()


if __name__ == "__main__":
    path = "D:\\Folder F\\phamtuananh@23020010\\My Study\\Year2526\\Semester II\\Testing\\CREDIT\\input.txt"

    data = read_data(path)
    total, pass_count, fail_count, result_dist = analyze(data)

    print(f"Total: {total}")
    print(f"Pass: {pass_count}")
    print(f"Fail: {fail_count}")
    print(f"Distribution: {result_dist}")

    plot_pass_fail(pass_count, fail_count)
    plot_distribution(result_dist)